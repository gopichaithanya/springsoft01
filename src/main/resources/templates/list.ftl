<div class="generic-container">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">Employee </span></div>
		<div class="panel-body">
	        <div class="formcontainer">
	            <div class="alert alert-success" role="alert" ng-if="ctrl.successMessage">{{ctrl.successMessage}}</div>
	            <div class="alert alert-danger" role="alert" ng-if="ctrl.errorMessage">{{ctrl.errorMessage}}</div>
	            <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
	                <input type="hidden" ng-model="ctrl.employee.id" />
	                <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="uname">Name</label>
	                        <div class="col-md-7">
	                            <input type="text" ng-model="ctrl.employee.name" id="uname" class="username form-control input-sm" placeholder="Enter your name" required ng-minlength="3"/>
	                        </div>
	                    </div>
	                </div>
                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="job">Job Description</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.employee.job" id="job" class="job form-control input-sm" placeholder="Enter your job description" required ng-minlength="3"/>
                            </div>
                        </div>
                    </div>
	                <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="salary">Salary</label>
	                        <div class="col-md-7">
	                            <input type="text" ng-model="ctrl.employee.salary" id="salary" class="form-control input-sm" placeholder="Enter your Salary." required ng-pattern="ctrl.onlyNumbers"/>
	                        </div>
	                    </div>
	                </div>
                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="address">Address</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.employee.address" id="address" class="address form-control input-sm" placeholder="Enter your address" required ng-minlength="3"/>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="email">Email</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.employee.email" id="email" class="email form-control input-sm" placeholder="Enter your email" required ng-minlength="3"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="phone">Phone</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.employee.phone" id="phone" class="phone form-control input-sm" placeholder="Enter your phone" required ng-minlength="3"/>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="state">State</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.employee.state" id="state" class="state form-control input-sm" placeholder="Enter your state" required ng-minlength="3"/>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="zipcode">ZIP</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.employee.zipcode" id="zipcode" class="zipcode form-control input-sm" placeholder="Enter your zipcode" required ng-minlength="3"/>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="country">Country</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.employee.country" id="country" class="country form-control input-sm" placeholder="Enter your country" required ng-minlength="3"/>
                            </div>
                        </div>
                    </div>
	                <div class="row">
	                    <div class="form-actions floatRight">
	                        <input type="submit"  value="{{!ctrl.employee.id ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid || myForm.$pristine">
	                        <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset Form</button>
	                    </div>
	                </div>
	            </form>
    	    </div>
		</div>	
    </div>
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">List of Employees </span></div>
		<div class="panel-body">
			<div class="table-responsive">
		        <table class="table table-hover">
		            <thead>
		            <tr>
		                <th>ID</th>
		                <th>NAME</th>
		                <th>SALARY</th>
		                <th>ADDRESS</th>
						<th>EMAIL</th>
						<th>PHONE</th>
						<th>STATE</th>
						<th>ZIPCODE</th>
						<th>COUNTRY</th>
		                <th width="100"></th>
		                <th width="100"></th>
		            </tr>
		            </thead>
		            <tbody>
		            <tr ng-repeat="u in ctrl.getAllEmployees()">
		                <td>{{u.id}}</td>
		                <td>{{u.name}}</td>
		                <td>{{u.salary}}</td>
		                <td>{{u.address}}</td>
						<td>{{u.email}}</td>
						<td>{{u.phone}}</td>
						<td>{{u.state}}</td>
						<td>{{u.zipcode}}</td>
						<td>{{u.country}}</td>
		                <td><button type="button" ng-click="ctrl.editEmployee(u.id)" class="btn btn-success custom-width">Edit</button></td>
		                <td><button type="button" ng-click="ctrl.removeEmployee(u.id)" class="btn btn-danger custom-width">Remove</button></td>
		            </tr>
		            </tbody>
		        </table>		
			</div>
		</div>
    </div>
</div>