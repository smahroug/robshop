'use strict';
angular
    .module('app.core')
    .controller('HomeController', function($scope,$location,RobotService) {
    	var vm = this;
    	vm.robots = [];
    	vm.robots = getAllRobots();

        function getAllRobots(){
        	RobotService.getAllRobots().then(function(result) {  
        		return vm.robots = result ;
    	    });
        }
        
        vm.removeRobot = function(id){
            console.log('About to remove Robot with id '+id);
            RobotService.removeRobot(id)
                .then(
                    function(){
                        console.log('Robot '+id + ' removed successfully');
                        getAllRobots();
                    },
                    function(errResponse){
                        console.error('Error while removing robot '+id +', Error :'+errResponse.data);
                    }
                );
        }


        vm.editRobot = function(id) {
            $location.url('/view/'+ id);
        };

    });
