<%@ include file="../../includes/header.jsp" %>
<%@ include file="../../includes/navbar.jsp"%>
<%@ include file="../../includes/subnav_admin.jsp"%>

<script>
    $(document).ready(function() {
        //attach an onclick function to the remove buttons
        $('.remove_button').click(function(){
        //log name button, and content of associated text box

            console.log(this.name);
            console.log($('#'+ this.name).val());
            //clear the value / content of the textbox
            $('#'+ this.name).val('')
            //submit the form
            $('#elementType').submit();
        });


    });
</script>


<div class="wrapper">

    <%--SIDEBAR--%>
    <%@ include file="element_sidebar.jsp"%>
    <div id="main-wrapper" class="col-sm-10">
        <div class="col-sm-8">

            <c:set var="idx" value="0" scope="page" />
            <form:form class="form-horizontal" modelAttribute="elementType" action="/admin/element/update" method="post">
                <form:hidden path="id" />
                <form:hidden path="version" />

                <div class="row">
                    <div class="form-group">
                        <label for="inputElementTypeName" class="col-sm-2 control-label ">Element Type</label>
                        <div class="col-sm-8">
                            <form:input path="elementTypeName" type="text" id="inputElementTypeName" cssClass="form-control"/>

                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-sm-10">
                        <hr>
                    </div>
                </div>

                <c:forEach items="${elementType.elementList}" var="element">
                    <form:hidden path="elementList[${idx}].id" />
                    <form:hidden path="elementList[${idx}].version" />
                    <div class="row">
                        <div class="form-group">
                            <Label class="col-sm-3 control-label" for="${idx}">Element</Label>
                            <div class="col-sm-7">
                                <div class="input-group">
                                    <form:input path="elementList[${idx}].elementName" id="${idx}" cssClass="form-control" />
                                        <span class="input-group-btn">
                                            <button name="${idx}" class="btn btn-default remove_button" type="button">Remove</button>
                                        </span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <c:set var="idx" value="${idx + 1}" scope="page" />
                </c:forEach>

                <div class="row">
                    <div class="form-group">
                        <Label class="col-sm-3 control-label" for="inputNewElement">New Element</Label>
                       <div class="col-sm-7">
                           <input type="text" class="form-control" name="inputNewElement" id="inputNewElement"/>
                       </div>
                    </div>
                </div>

                <div class="row">
                    <button class="btn btn-primary">UPDATE</button>
                </div>

            </form:form>

        </div>



        </div>
    </div>
</div>

<%@ include file="../../includes/footer.jsp" %>