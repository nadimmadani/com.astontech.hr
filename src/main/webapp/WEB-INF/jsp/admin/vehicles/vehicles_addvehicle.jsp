<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="../../includes/header.jsp" %>
<%@ include file="../../includes/navbar.jsp"%>
<%@ include file="../../includes/subnav_admin.jsp"%>

<div class="Wrapper">

    <%@ include file="vehicles_sidebar.jsp"%>

    <div id="main-wraper" class="col-sm-10">
        <div class="col-lg-8">
            <form:form cssClass="form-horizontal" modelAttribute="vehiclesVO" action="/admin/vehicles/addvehicle" method="post">
                <fieldset>
                    <legend>Insert New Vehicle </legend>

                    <div class="form-group">
                        <Label for="inputNewVehicleMake" class="col-lg-2 control-label">Vehicle Make</Label>
                        <div class="col-sm-10">
                            <form:select path="newVehicleModel.vehicleMake.id" class="form-control">
                                <c:forEach var="vehicleMake" items="${vehicleMakeList}">
                                    <option value="${vehicleMake.id}" path="newVehicleMakeName" id="inputNewVehicleMake" >${vehicleMake.vehicleMakeName}</option>
                                </c:forEach>
                            </form:select>
                        </div>
                    </div>

                    <div class="form-group">
                        <Label for="inputNewVehicleModel" class="col-lg-2 control-label">Vehicle Model</Label>
                        <div class="col-sm-10">
                            <form:select path="newVehicleModel.id" class="form-control">
                                <c:forEach var="vehicleModel" items="${vehicleModelList}">

                                    <option value="${vehicleModel.id}" id="inputNewVehicleModel" >${vehicleModel.vehicleModelName}</option>

                                </c:forEach>
                            </form:select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="inputNewVehicleYear" class="col-lg-2 control-label">Year</label>
                        <div class="col-sm-10">
                            <form:input path="newVehicleYear" type="text" class="form-control" id="inputNewVehicleYear" placeholder="Vehicle Year"></form:input>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="inputNewVehicleColor" class="col-lg-2 control-label">Color</label>
                        <div class="col-sm-10">
                            <form:input path="newVehicleColor" type="text" class="form-control" id="inputNewVehicleColor" placeholder="Vehicle Color"></form:input>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="inputNewVehicleLicense" class="col-lg-2 control-label">License Plate</label>
                        <div class="col-sm-10">
                            <form:input path="newVehicleLicensePlate" type="text" class="form-control" id="inputNewVehicleLicense" placeholder="License plate"></form:input>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="inputNewVehicleVin" class="col-lg-2 control-label">VIN Number</label>
                        <div class="col-sm-10">
                            <form:input path="newVehicleVin" type="text" class="form-control" id="inputNewVehicleVin" placeholder=" VIN Number"></form:input>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-lg-10 col-lg-offset-2">
                            <form:button type="reset" value="cancel" class="btn btn-default">Cancel</form:button>
                            <form:button type="submit" value="save" class="btn btn-primary">Save</form:button>
                        </div>
                    </div>

                </fieldset>
            </form:form>
        </div>
    </div>
</div>