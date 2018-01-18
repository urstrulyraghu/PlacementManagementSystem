angular.module("studentModule",[]);
angular.module("studentModule")
    .controller("studentData",function($scope,$http){
        $http.get('http//localhost:8080/Placemets/').then(function(response){
            $scope.student = response.data;
        })
    });
angular.module("studentModule")
    .controller("studentRegister",function($http,$scope){
        var student = {"name":$scope.name,"id":$scope.id,"qualification":$scope.qualification,"email":$scope.email,"cgpa10":$scope.cgpa10,"cgpa12":$scope.cgpa12,"cgpaUg":$scope.cgpaUg};
        $http.post('http//localhost:8080/Placements/',student).then(function(response){
             if(response.data){
                alert("registered and waiting for approval");
             }else{
                alert("couldn't register");
             }
        })
    });
angular.module("studentModule")
    .controller("studentUpdate",function($http,$scope){
        var student = {"name":$scope.name,"id":$scope.id,"qualification":$scope.qualification,"email":$scope.email,"cgpa10":$scope.cgpa10,"cgpa12":$scope.cgpa12,"cgpaUg":$scope.cgpaUg};
        $http.put('http//localhost:8080/Placements/'+$scope.id,student).then(function(response){
             if(response.data){
                alert("updated successfully");
             }else{
                alert("couldn't update");
             }
        });
    });
angular.module("companyModule",[]);
angular.module("companyModule")
    .controller("companyList",function($scope,$http){
        $http.get("companies.json").then(function(response){
            console.log(response.data.companies[1]);
            $scope.companies = response.data.companies;
        });
    });
angular.module("companyModule")
    .controller("CompanyAddition",function($scope,$http){
        $scope.companyName = "";
        $scope.jobProfile = "";
        $scope.package = 0;
        $scope.date = "";
        $scope.description = "";
        $scope.addCompany = function(){
            company = {"name":$scope.companyName,"jobRole":$scope.jobProfile,"payPackage":$scope.package,"date":$scope.date.toString(),"description":$scope.description};
            $http.post("http//localhost:8080/Placements/Company/create").then(function(response){
                if(response){
                    alert("added successfully");
                }else{
                    alert("could not add a company");
                }
            });
        }
    });