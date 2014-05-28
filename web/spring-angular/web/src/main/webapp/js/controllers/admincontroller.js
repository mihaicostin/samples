(function (ns) {

    ns.AdminController = function($scope) {

        //TODO: List needs to be a Resource provided by server.
        $scope.users = [
            {username: "Arya"},
            {username: "Bran"},
            {username: "Catelyn"},
            {username: "Daenerys"},
            {username: "Elia"}
        ];

        $scope.removeUser = function(index){
            $scope.users.splice(index, 1);
        }

    }

})(com.mc);