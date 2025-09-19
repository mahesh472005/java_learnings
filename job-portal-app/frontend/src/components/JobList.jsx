import { useEffect, useState } from "react";
import { getJobs, deleteJob } from "../api/jobApi";
import JobCard from "./JobCard";
import { toast } from "sonner";

export default function JobList({ onEdit }) {
  const [jobs, setJobs] = useState([]);

  useEffect(() => {
    loadJobs();
  }, []);

  const loadJobs = async () => {
    const { data } = await getJobs();
    setJobs(data);
  };

  const handleDelete = async (id) => {
    await deleteJob(id);
    toast.success("Job deleted successfully!");
    loadJobs();
  };

  return (
    <div className="grid gap-4 md:grid-cols-2">
      {jobs.map((job) => (
        <JobCard key={job.id} job={job} onDelete={handleDelete} onEdit={onEdit} />
      ))}
    </div>
  );
}
