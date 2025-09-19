<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*,com.mahesh.job_portal_app.model.JobPost" %>
<!DOCTYPE html>
<html>
<head>
    <title>All Jobs</title>
    <link rel="stylesheet" href="style.css">
    <style>
        .jobs-grid {
            display: grid;
            grid-template-columns: repeat(auto-fill, minmax(280px, 1fr));
            gap: 20px;
            margin-top: 20px;
        }
        .job-card {
            background: #fff;
            border-radius: 12px;
            padding: 20px;
            box-shadow: 0 4px 12px rgba(0,0,0,0.1);
            transition: transform 0.2s ease, box-shadow 0.2s ease;
            display: flex;
            flex-direction: column;
            justify-content: space-between;
        }
        .job-card:hover {
            transform: translateY(-5px);
            box-shadow: 0 6px 16px rgba(0,0,0,0.15);
        }
        .job-card h3 {
            margin: 0 0 10px;
            color: #2c3e50;
        }
        .job-card p {
            margin: 5px 0;
            color: #555;
        }
        .job-company {
            font-weight: bold;
            color: #1abc9c;
        }
        .job-location {
            font-size: 14px;
            color: #888;
        }
        .apply-btn {
            margin-top: 15px;
            padding: 10px 15px;
            background: #1abc9c;
            color: #fff;
            text-align: center;
            border-radius: 6px;
            font-weight: 500;
            text-decoration: none;
            transition: 0.3s;
        }
        .apply-btn:hover {
            background: #16a085;
        }
    </style>
</head>
<body>
    <div class="navbar">
        <h2 style="color:white;">Job Portal</h2>
        <div>
            <a href="home">Home</a>
            <a href="addjob">Add Job</a>
        </div>
    </div>
    <div class="container">
        <h1>Available Jobs</h1>
        <div class="jobs-grid">
            <%
                List<JobPost> jobs = (List<JobPost>) request.getAttribute("jobs");
                if (jobs != null && !jobs.isEmpty()) {
                    for (JobPost job : jobs) {
            %>
                <div class="job-card">
                    <div>
                        <h3><%= job.getTitle() %></h3>
                        <p class="job-company"><%= job.getCompany() %></p>
                        <p class="job-location">📍 <%= job.getLocation() %></p>
                        <p><%= job.getDesc() %></p>
                    </div>
                    <a href="" class="apply-btn">Apply Now</a>
                </div>
            <%
                    }
                } else {
            %>
                <p>No jobs found.</p>
            <%
                }
            %>
        </div>
    </div>
</body>
</html>
