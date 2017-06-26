(function(){
    'use strict';
    angular.module('carTracker').controller('VehicleDetailController',VehicleDetailController)
    VehicleDetailController.$inject=['vehicleService','$routeParams','alertService','readingService','$scope','$window','$location'];
    function VehicleDetailController(vehicleService,$routeParams,alertService, readingService,$window,$location,$scope){
        var carDetailVm = this;
        var signalD ;
        var timeD;
        carDetailVm.signal = ["fuelVolume","speed","engineHp","engineRpm"];
        carDetailVm.interval = ["hour","minute","second"];
        carDetailVm.sig = [];
        carDetailVm.ts=[];
        carDetailVm.geo=[];

        console.log($routeParams.vin);

        alertService.getAlertsByVin($routeParams.vin).then(function(response){
            carDetailVm.alerts=response;


        },function(error){
            console.log(error);
        });




        alertService.getAlertsByVin($routeParams.vin).then(function(response){
            carDetailVm.alerts=response;

        },function(error){
            console.log(error);
        });





        carDetailVm.viewMap = function () {
            console.log("viewMap");
            readingService.getSignalReadingByVin($routeParams.vin,'1','minute').then(function(response){
                carDetailVm.signals = response;


                for(var i = 0; i < carDetailVm.signals.length; i++ ){
                    carDetailVm.geo.push({
                        latitude: carDetailVm.signals[i].latitude,
                        longitude: carDetailVm.signals[i].longitude
                    })


                }

                console.log(carDetailVm.geo[0].latitude);
                console.log(carDetailVm.geo[0].longitude);
                var x = document.getElementById('viewMap');

                x.style.display = 'block';
                console.log('endfunc')





            },function(error){
                console.log(error);

            });

        }

        carDetailVm.testlog = function () {
            console.log("from test log func 111");
            var x = document.getElementById('myChart');

            x.style.display = 'block';

            new Chart(document.getElementById("myChart"), {
                type: 'line',

                data: {
                    labels: carDetailVm.ts,
                    datasets: [{
                        data: carDetailVm.sig,
                        label: carDetailVm.searchSignal,
                        borderColor: "#3e95cd",
                        fill: false,
                        borderWidth: 0.5
                    }
                    ]
                },
                options: {
                    title: {
                        display: true,
                        text: 'Variation of '+carDetailVm.searchSignal
                    },
                    elements: {
                        point:{
                            radius: 0
                        }
                    }
                }
            });
            console.log(Chart);
            console.log("from chart.js");
            console.log(carDetailVm.sig[0] + "found data");
        }




        carDetailVm.addCar = function (location,scope) {
            readingService.getSignalReadingByVin($routeParams.vin,carDetailVm.searchTime,carDetailVm.searchInterval).then(function(response){
                carDetailVm.signals = response;

                $scope.data = [];
                $scope.labels = [];


                console.log('carDetailVm.searchSignal'+carDetailVm.searchSignal);
                console.log('le : '+ carDetailVm.signals.length);
                for(var i = 0; i < carDetailVm.signals.length; i++ ){
                    switch(carDetailVm.searchSignal){
                        case 'fuelVolume':

                            console.log(carDetailVm.signals[i].fuelVolume+"hiiii");
                            carDetailVm.sig.push(carDetailVm.signals[i].fuelVolume);
                            $scope.data.push(carDetailVm.signals[i].fuelVolume);
                            break;
                        case 'speed':
                            carDetailVm.sig.push(carDetailVm.signals[i].speed);
                            $scope.data.push(carDetailVm.signals[i].speed);
                            break;
                        case 'engineHp':
                            carDetailVm.sig.push(carDetailVm.signals[i].engineHp);
                            $scope.data.push(carDetailVm.signals[i].engineHp);
                            break;
                        case 'engineRpm':
                            carDetailVm.sig.push(carDetailVm.signals[i].engineRpm);
                            $scope.data.push(carDetailVm.signals[i].engineRpm);
                            break;

                    }
                    carDetailVm.ts.push(carDetailVm.signals[i].timestamp);
                    $scope.labels.push(carDetailVm.signals[i].timestamp);
                }

                console.log(carDetailVm.sig[0]);
                console.log(carDetailVm.ts[0]);
                $scope.data = carDetailVm.sig;
                $scope.labels = carDetailVm.ts;
                console.log('endfunc')


                    carDetailVm.testlog();


            },function(error){
                console.log(error);

            });
            console.log(carDetailVm.searchSignal);



        };


    }




})();