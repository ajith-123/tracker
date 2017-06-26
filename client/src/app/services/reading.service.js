/**
 * Created by Ajith on 6/21/17.
 */
(function(){
    'use strict';
    angular.module('carTracker').service('readingService',readingService);


    readingService.inject=['$q','$http','CONFIG'];

    function readingService($q,$http,CONFIG){
        var self = this;
        self.getSignalReadingByVin= getSignalReadingByVin;

        function getSignalReadingByVin(vin,value,interval)
        {
            return $http.get(CONFIG.API_HOST+'/api/readings/signals/'+vin+'/'+value+'/'+interval)


                .then(successFn,errorFn);

        };





        function successFn(response){
            return response.data;
        }
        function errorFn(error){
            return $q.reject(error);
        }

    }


})();