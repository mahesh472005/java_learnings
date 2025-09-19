import axios from "axios";

const API = "http://localhost:8080";

export const getJobs = () => axios.get(`${API}/jobs`);
export const getJob = (id) => axios.get(`${API}/job/${id}`);
export const addJob = (job) => axios.post(`${API}/job`, job);
export const updateJob = (job) => axios.put(`${API}/job`, job);
export const deleteJob = (id) => axios.delete(`${API}/job/${id}`);
