<%@page import="com.tonduong.model.NewsModel"%>
<%@page import="java.util.ArrayList"%>
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

			<div class="ace-settings-container" id="ace-settings-container">
				<div class="btn btn-app btn-xs btn-warning ace-settings-btn"
					id="ace-settings-btn">
					<i class="ace-icon fa fa-cog bigger-130"></i>
				</div>

				<div class="ace-settings-box clearfix" id="ace-settings-box">
					<div class="pull-left width-50">
						<div class="ace-settings-item">
							<div class="pull-left">
								<select id="skin-colorpicker" class="hide">
									<option data-skin="no-skin" value="#438EB9">#438EB9</option>
									<option data-skin="skin-1" value="#222A2D">#222A2D</option>
									<option data-skin="skin-2" value="#C6487E">#C6487E</option>
									<option data-skin="skin-3" value="#D0D0D0">#D0D0D0</option>
								</select>
							</div>
							<span>&nbsp; Choose Skin</span>
						</div>

						<div class="ace-settings-item">
							<input type="checkbox" class="ace ace-checkbox-2 ace-save-state"
								id="ace-settings-navbar" autocomplete="off" /> <label
								class="lbl" for="ace-settings-navbar"> Fixed Navbar</label>
						</div>

						<div class="ace-settings-item">
							<input type="checkbox" class="ace ace-checkbox-2 ace-save-state"
								id="ace-settings-sidebar" autocomplete="off" /> <label
								class="lbl" for="ace-settings-sidebar"> Fixed Sidebar</label>
						</div>

						<div class="ace-settings-item">
							<input type="checkbox" class="ace ace-checkbox-2 ace-save-state"
								id="ace-settings-breadcrumbs" autocomplete="off" /> <label
								class="lbl" for="ace-settings-breadcrumbs"> Fixed
								Breadcrumbs</label>
						</div>

						<div class="ace-settings-item">
							<input type="checkbox" class="ace ace-checkbox-2"
								id="ace-settings-rtl" autocomplete="off" /> <label class="lbl"
								for="ace-settings-rtl"> Right To Left (rtl)</label>
						</div>

						<div class="ace-settings-item">
							<input type="checkbox" class="ace ace-checkbox-2 ace-save-state"
								id="ace-settings-add-container" autocomplete="off" /> <label
								class="lbl" for="ace-settings-add-container"> Inside <b>.container</b>
							</label>
						</div>
					</div>
					<!-- /.pull-left -->

					<div class="pull-left width-50">
						<div class="ace-settings-item">
							<input type="checkbox" class="ace ace-checkbox-2"
								id="ace-settings-hover" autocomplete="off" /> <label
								class="lbl" for="ace-settings-hover"> Submenu on Hover</label>
						</div>

						<div class="ace-settings-item">
							<input type="checkbox" class="ace ace-checkbox-2"
								id="ace-settings-compact" autocomplete="off" /> <label
								class="lbl" for="ace-settings-compact"> Compact Sidebar</label>
						</div>

						<div class="ace-settings-item">
							<input type="checkbox" class="ace ace-checkbox-2"
								id="ace-settings-highlight" autocomplete="off" /> <label
								class="lbl" for="ace-settings-highlight"> Alt. Active
								Item</label>
						</div>
					</div>
					<!-- /.pull-left -->
				</div>
				<!-- /.ace-settings-box -->
			</div>
			<!-- /.ace-settings-container -->

			<div class="page-header">
				<h1>
					Dashboard <small> <i
						class="ace-icon fa fa-angle-double-right"></i> overview &amp;
						stats
					</small>
				</h1>
			</div>
			<!-- /.page-header -->

			<div class="row">
				<div class="col-xs-12">
					<table class="table">
						<thead>
							<tr>
								<th scope="col">#</th>
								<th scope="col">Tên bài viết</th>
								<th scope="col">Mô tả ngắn</th>
							</tr>
						</thead>
						<tbody class="rowBody">
							<%
							Integer i = 0;
							for (NewsModel news : (ArrayList<NewsModel>) request.getAttribute("newsList")) {
							%>
							<tr class="rowItem">
								<th scope="row"><%=++i%></th>
								<td><%=news.getTitle()%></td>
								<td><%=news.getShortdescription()%></td>
							</tr>
							<%
							}
							%>

						</tbody>
					</table>
					<div class="text-center">
						<ul class="pagination"></ul>
					</div>
					<script>
      const pagination = (select, option) => {
        const page =
          document.getElementById(select) ||
          document.querySelector("." + select);
        const render = (active) => {
          page.innerHTML = "";
          for (let index = 1; index <= option.total; index++) {
            const item = document.createElement("li");
            item.classList.add("page-item");
            const innerItem = document.createElement("a");
            innerItem.classList.add("page-link");
            //innerItem.setAttribute("href", "./admin-news?count=" + index+"&limit=" +option.visible);
            innerItem.innerText = index;
            item.appendChild(innerItem);
            item.onclick = (e) => {
              const url = "http://localhost:8000/api-admin/news?count="+ index +"&limit="+option.visible;
              option.onClick(url, e.target.innerText);
              render(e.target.innerText);
            };
            if (index == active) {
              item.classList.add("active");
            }
            page.appendChild(item);
          }
        };
        render(option.active);
      };
      pagination("pagination", {
        visible: ${limit},
        total: Math.ceil(${count}/${limit}),
        active: ${page},
        onClick: (url, value) => {
          fetch(url)
          .then(response => response.json())
          .then(data => 
          	{
          		const row  = document.querySelector(".rowBody");
          		row.innerHTML = "";
          		data.forEach((item, index)=>{
					row.innerHTML+=''+
						'<tr class="rowItem">'+
						'<th scope="row">' + ++index+'</th>'+
						'<td>' + item.title + '</td>' +
						'<td>'+item.shortdescription + '</td>'+
					'</tr>'
					;          			
          		})
          	}
          ); 
          },
      });
    </script>
				</div>
				<!-- /.col -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /.page-content -->
	</div>
</div>
<!-- /.main-content -->
