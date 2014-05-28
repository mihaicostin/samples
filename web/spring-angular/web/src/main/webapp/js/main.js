(function (ns) {

    angular
        .module('springular', ['ngRoute'])
//        .directive("myDirective", ns.MyDirective)
//        .filter("myFilter", ns.MyFilter)
        .service('util', ns.Util)
        .service('connector', ns.Connector)
        .config([
            '$routeProvider', '$locationProvider', '$httpProvider',
            function ($routeProvider, $locationProvider, $httpProvider) {
                // Front pages
                $routeProvider.
                    when('/login', {
                        templateUrl: 'pages/login.htm',
                        controller: ns.LoginController
                    }).when('/admin', {
                        templateUrl: 'pages/admin.htm',
                        controller: ns.AdminController
                    }).otherwise({
                        redirectTo: '/login'
                    });

//                $locationProvider.html5Mode(true);

            }
        ])
        .run(function ($rootScope, $location, $route, connector) {
            $rootScope.$on("$routeChangeStart", function (event, next, current) {
                $rootScope.authenticated = false;

                connector.isAuthenticated(
                    function () {
                        if ($location.url() === '/login') {
                            $location.url("/admin");
                        }
                        $rootScope.authenticated = true;
                    },
                    function () {
                        if ($location.url() !== '/login') {
                            $location.url("/login");
                        }
                        $rootScope.authenticated = false;
                    })
            });
        });
})(com.mc);