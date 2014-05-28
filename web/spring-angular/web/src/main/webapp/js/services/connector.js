/**
 * Custom AngularJS services used by the APP logic
 */
(function (ns) {

    ns.Connector = function ($location, $http) {


        function isAuthenticated(success, failed) {

            $http({
                method: 'GET',
                url: 'rest/auth/test'
            })
                .success(function () {
                    success()
                })
                .error(function () {
                    failed()
                });
        }


        return {
            'isAuthenticated': isAuthenticated
        }

    }
})(com.mc);
