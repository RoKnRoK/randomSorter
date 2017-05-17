(function(){
  angular.module('RandomSorter', [])
  .controller('SortController', ['$scope', 'SortResultService', function($scope, SortResultService){

    $scope.sort = {'array' : null, 'result' : null}
    console.log('Gonna fetch them all');
    fetchAllSortResults();

    $scope.onSort = function(){
        SortResultService.addSortResult($scope.sort.array)
        .then(fetchAllSortResults);
    }
    $scope.clear = function(){
      $scope.sort.array = null;
    };
    $scope.clearAllResults = function(){
        if (confirm("This action cannot be undone! Are you sure you want to proceed?")){
            SortResultService.clearAllResults()
            .then(fetchAllSortResults);
        }
    }

    function fetchAllSortResults(){
    SortResultService.fetchAllSortResults().then(
        function(result) {
            console.log(result);
            $scope.sort.result = result;
        }
    );
    }

  }])

})()