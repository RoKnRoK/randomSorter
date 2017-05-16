(function(){
  angular.module('RandomSorter', ['ngAnimate'])
  .constant('serviceUrl', 'http://localhost:8080/RandomSorter/sort')
  .controller('SortController', function($scope, $http, serviceUrl){

    $scope.clear = function(){
          $scope.sort = { array: null, result: null};
        };
    $scope.onSort = function(){
        successCallback = function(result){
            console.log(result);
            $scope.sort.result = result.data;
        };

        $http({
            url: serviceUrl,
            method: "POST",
            params: {"array": $scope.sort.array}
        }).then(
        successCallback,
        function(errResponse){
            console.error('Error while updating User');
        });
    }

  })

})()