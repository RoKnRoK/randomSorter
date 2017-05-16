(function(){
    angular.module('RandomSorter')
    .constant('serviceUrl', 'http://localhost:8080/RandomSorter/sortResult/')
    .factory('SortResultService', function($http, $q, serviceUrl){

        var factory = {
            fetchAllSortResults: fetchAllSortResults,
            addSortResult: addSortResult
        };

        return factory;

        function fetchAllSortResults() {
            var deferred = $q.defer();
                $http.get(serviceUrl+'fetchAll')
                    .then(
                    function (response) {
                        deferred.resolve(response.data);
                    },
                    function(errResponse){
                        console.error('Error while fetching all sort results');
                        deferred.reject(errResponse);
                    }
                );
                return deferred.promise;

        }

        function addSortResult(array) {
        var deferred = $q.defer();
                        $http({
                                            url: serviceUrl+'create',
                                            method: "POST",
                                            params: {"array": array }
                                        }).then(
                            function (response) {
                                deferred.resolve(response.data);
                            },
                            function(errResponse){
                                console.error('Error while fetching all sort results');
                                deferred.reject(errResponse);
                            }
                        );
                        return deferred.promise;
               /* $http({
                    url: serviceUrl+'create',
                    method: "POST",
                    params: {"array": array }
                }).then(
                    fetchAllSortResults,
                    function(errResponse){
                        console.error('Error while updating User');
                });*/
        }

    })
})()