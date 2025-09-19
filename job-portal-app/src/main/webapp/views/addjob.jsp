
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Add Job</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <div class="navbar">
        <h2 style="color:white;">Job Portal</h2>
        <div>
            <a href="home">Home</a>
            <a href="viewalljobs">View Jobs</a>
        </div>
    </div>
    <div class="container">
        <h1>Add New Job</h1>
        <form action="handleForm" method="post">
            <label for="title">Job Title</label>
            <input type="text" id="title" name="title" required>

            <label for="company">Company</label>
            <input type="text" id="company" name="company" required>

            <label for="location">Location</label>
            <input type="text" id="location" name="location" required>

            <label for="desc">Description</label>
            <textarea id="desc" name="desc" rows="4" required></textarea>

            <button type="submit">Submit Job</button>
        </form>
    </div>
</body>
</html>
