@echo off
title Job Portal App Starter
echo ==============================
echo Starting Job Portal Application...
echo ==============================

:: Start Spring Boot backend
echo Starting Spring Boot Backend...
cd backend
start cmd /k mvn spring-boot:run
cd ..

:: Start React frontend
echo Starting React Frontend...
cd frontend
start cmd /k npm run dev
cd ..

echo ==============================
echo Both backend (8080) and frontend (5173) are starting...
echo Close these windows to stop.
pause
