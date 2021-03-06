<%@ include file="../../includes/header.jsp" %>
<%@ include file="../../includes/navbar.jsp"%>
<%@ include file="../../includes/subnav_admin.jsp"%>

<div class="Wrapper">

    <%@ include file="vehicles_sidebar.jsp"%>

    <div id="main-wraper" class="col-sm-10">
        <div class="col-lg-8">
            <form:form cssClass="form-horizontal" modelAttribute="vehiclesVo" action="/admin/vehicles/addmake" method="post">
                <fieldset>
                    <legend>Add Vehicle Make</legend>
                    <div class="form-group">
                        <label for="inputNewVehicleMake" class="col-lg-2 control-label">Vehicle Make</label>
                        <div class="col-sm-10">
                            <form:input path="newVehicleMakeName" type="text" class="  form-control" id="inputNewVehicleMake" placeholder="Vehicle Make"></form:input>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="inputNewVehicleModel" class="col-lg-2 control-label">Vehicle Model</label>
                        <div class="col-sm-10">
                            <form:input path="newVehicleModelName" type="text" class="form-control" id="inputNewVehicleModel" placeholder="Vehicle Model"></form:input>
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