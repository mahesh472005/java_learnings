import { useState } from "react";
import JobList from "../components/JobList";
import JobForm from "../components/JobForm";
import Navbar from "../components/Navbar";

export default function Home() {
  const [editingJob, setEditingJob] = useState(null);

  return (
    <div className="min-h-screen bg-gray-100">
      <Navbar />
      <div className="container mx-auto p-6">
        <div className="grid md:grid-cols-3 gap-6">
          <div className="md:col-span-2">
            <JobList onEdit={setEditingJob} />
          </div>
          <div id="add">
            <JobForm job={editingJob} onSuccess={() => setEditingJob(null)} />
          </div>
        </div>
      </div>
    </div>
  );
}
