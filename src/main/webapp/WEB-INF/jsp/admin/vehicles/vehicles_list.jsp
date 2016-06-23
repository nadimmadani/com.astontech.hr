<%@ include file="../../includes/header.jsp" %>
<%@ include file="../../includes/navbar.jsp"%>
<%@ include file="../../includes/subnav_admin.jsp"%>


<div class="wrapper">

    <%--SIDEBAR--%>
    <%@ include file="vehicles_sidebar.jsp"%>
    <div id="main-wrapper" class="col-sm-10">
        <div class="col-sm-12">

            <table class="table table-striped table-hover">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Make</th>
                    <th>Model</th>
                    <th>Year</th>
                    <th>Color</th>
                    <th>License Plate</th>
                    <th>VIN</th>

                </tr>
                </thead>
                <form:form cssClass="form-horizontal" modelAttribute="vehicleVO" action="/admin/vehicles/updatevehicle" method="post">
                    <c:forEach var="vehicle" items="${newVehicleList}">
                        <form:hidden path="vehicle.version" />
                        <tr>
                            <td>${vehicle.id}</td>
                            <td>
                                <form:select path="newVehicleModel.vehicleMake.id" class="form-control">
                                    <c:forEach var="vehicleMake" items="${vehicleMakeList}">
                                        <c:choose>
                                            <c:when test="${vehicle.vehicleModel.vehicleMake.id == vehicleMake.id}">
                                                <form:option selected="selected" value="${vehicleMake.id}" path="newVehicleMakeName" id="inputNewVehicleMake" >${vehicle.vehicleModel.vehicleMake.vehicleMakeName}</form:option>
                                            </c:when>
                                            <c:otherwise>
                                                <form:option value="${vehicleMake.id}"  id="inputNewVehicleMake" >${vehicleMake.vehicleMakeName}</form:option>
                                            </c:otherwise>
                                        </c:choose>
                                     </c:forEach>
                                 </form:select>
                            </td>
                            <%--<td>${vehicle.vehicleModel.vehicleMake.vehicleMakeName}</td>--%>

                            <td>
                                <form:select path="newVehicleModel.id" class="form-control">
                                    <c:forEach var="vehicleModel" items="${vehicleModelList}">
                                        <c:choose>
                                            <c:when test="${vehicle.vehicleModel.id == vehicleModel.id}">
                                                <form:option selected="selected" value="${vehicleModel.id}" id="inputNewVehicleModel" path="newVehicleModelName" >${vehicle.vehicleModel.vehicleModelName}</form:option>
                                            </c:when>
                                            <c:otherwise>
                                                <form:option value="${vehicleModel.id}" id="inputNewVehicleModel" >${vehicleModel.vehicleModelName}</form:option>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                </form:select>


                            </td>
                            <%--<td>${vehicle.vehicleModel.vehicleModelName}</td>--%>
                            <td><form:input path="newVehicleYear" type="text" class="form-control" id="inputNewVehicleYear" placeholder="${vehicle.year}"></form:input></td>
                            <%--<td>${vehicle.year}</td>--%>
                            <td><form:input path="newVehicleColor" type="text" class="form-control" id="inputNewVehicleColor" placeholder="${vehicle.color}"></form:input></td>
                            <%--<td>${vehicle.color}</td>--%>
                            <td><form:input path="newVehicleLicensePlate" type="text" class="form-control" id="inputNewVehicleLicense" placeholder="${vehicle.licensePlate}"></form:input></td>
                            <%--<td>${vehicle.licensePlate}</td>--%>
                            <td><form:input path="newVehicleVin" type="text" class="form-control" id="inputNewVehicleVin" placeholder="${vehicle.vin}"></form:input></td>
                            <%--<td>${vehicle.vin}</td>--%>
                            <td><a href="/admin/element/edit/${elementType.id}" >update</a> </td>
                            <td><a href="/admin/vehicle/delete/${vehicle.id}" >Delete</a> </td>
                        </tr>
                    </c:forEach>
                </form:form>

            </table>



        </div>
    </div>
</div>

<%@ include file="../../includes/footer.jsp" %>