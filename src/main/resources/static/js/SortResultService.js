(function(){
    angular.module('RandomSorter')
    .constant('serviceUrl', 'http://localhost:8080/RandomSorter/sortResult/')
    .factory('SortResultService', function($http, $q, serviceUrl){

        var factory = {
            fetchAllSortResults: fetchAllSortResults,
            addSortResult: addSortResult,
            clearAllResults : clearAllResults
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

        function clearAllResults() {
            var deferred = $q.defer();
            $http.delete(serviceUrl+'clearAll')
                .then(
                function (response) {
                    deferred.resolve(response.data);
                },
                function(errResponse){
                    console.error('Error while removing all sort results');
                    deferred.reject(errResponse);
                }
            );
            return deferred.promise;

        }

        function addSortResult(array) {
        var deferred = $q.defer();
        $http(
            {   url: serviceUrl+'create',
                method: 'POST',
                data: '['+ array +']'
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
        }
    })
})()