<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.tonduong.model.CategoryModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<div class="main-content">
	<div class="main-content-inner">
		<div class="breadcrumbs ace-save-state" id="breadcrumbs">
			<ul class="breadcrumb">
				<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Home</a>
				</li>
				<li class="active">Dashboard</li>
			</ul>
			<!-- /.breadcrumb -->

			<div class="nav-search" id="nav-search">
				<form class="form-search">
					<span class="input-icon"> <input type="text"
						placeholder="Search ..." class="nav-search-input"
						id="nav-search-input" autocomplete="off" /> <i
						class="ace-icon fa fa-search nav-search-icon"></i>
					</span>
				</form>
			</div>
			<!-- /.nav-search -->
		</div>

		<div class="page-content">
			<form action="./api-admin/news" method="post" enctype="multipart/form-data">
				<div class="form-group">
					<label for="exampleInputPassword1">Thể loại</label> <select
						class="form-select w-100" style="width: 100%"
						aria-label="Default select example">
						<option selected>Thể loại</option>
						<%
						for (CategoryModel category : (List<CategoryModel>) request.getAttribute("categorys")) {
						%>
						<option value="<%=category.getCode()%>"><%=category.getName()%></option>
						<%
						}
						%>
					</select>
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1">Tiêu đề</label> <input
						class="form-control" id="exampleInputPassword1"
						placeholder="Tiêu đề bài viết">
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1">Hình đại diện</label> <input
						type="file"
						class="form-control" id="exampleInputPassword1"
						placeholder="Link ảnh đại diện">
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1">Mô tả ngắn</label> <input
						class="form-control" id="exampleInputPassword1"
						placeholder="Mô tả ngắn">
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1">Nội dung</label>
					<textarea class="form-control" id="content"
						placeholder="Nội dung bài viết" rows="10" name="content"></textarea>
					<script>
						// Replace the <textarea id="editor1"> with a CKEditor 4
						// instance, using default configuration.
						var ckeditor = CKEDITOR.replace('content');
					</script>
				</div>
				<button type="submit" class="btn btn-primary">Submit</button>
			</form>
		</div>
	</div>
</div>