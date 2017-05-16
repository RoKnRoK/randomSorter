(function(){
  angular.module('RandomSorter', [])
  .controller('SortController', ['$scope', 'SortResultService', function($scope, SortResultService){

    $scope.clear = function(){
          $scope.sort = { array: null, result: null};
        };
         function fetchAllSortResults(){
            SortResultService.fetchAllSortResults().then(
                function(result) {
                    console.log(result);
                    $scope.sort.result = result;
                }
            );
          }
    $scope.onSort = function(){
        SortResultService.addSortResult($scope.sort.array)
        .then(fetchAllSortResults);
       /* successCallback = function(result){
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
        });*/
    }

  }])

})()