(function(ns) {
    ns.LoginController = function($scope, $route, $location, $http) {

        $scope.loginMessage = "Please login in order to proceed.";
        $scope.error = "";


        $scope.changeInputStyle = function(elem) {
            if (elem.target.value != undefined && elem.target.value !== '') {
                var elementName = elem.target.name;
                $('[name='+elementName+']').addClass('blur-effect');
            } else {
                var elementName = elem.target.name;
                $('[name='+elementName+']').removeClass('blur-effect');
            }
        };

        $scope.login = function() {
            $scope.error = "";



            $http({
                method: 'POST',
                url: ns.Constants.LOGIN_PATH,
                //TODO: it would be better to send the user & pass as 'encrypted' post data
                params: {username: $scope.username, password: $scope.password},
                //data: {username: $scope.username, password: $scope.password},
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
                }
            })
            .success(function(data, status) {
                $location.url("/admin");
            })
            .error(function(data, status) {
                setErrorMessage(ns.Constants.LOGIN_ERROR);
            });

        };

        function setErrorMessage(message) {
            $scope.loginMsgClass = "login-err";
            $scope.loginError = message;
        }
    }

})(com.mc);