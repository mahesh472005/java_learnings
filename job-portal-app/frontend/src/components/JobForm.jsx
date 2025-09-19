import { useState, useEffect } from "react";
import { addJob, updateJob } from "../api/jobApi";
import { toast } from "sonner";

export default function JobForm({ job, onSuccess }) {
  const [form, setForm] = useState({ title: "", company: "", location: "", description: "" });

  useEffect(() => {
    if (job) setForm(job);
  }, [job]);

  const handleChange = (e) => setForm({ ...form, [e.target.name]: e.target.value });

  const handleSubmit = async (e) => {
    e.preventDefault();
    if (form.id) {
      await updateJob(form);
      toast.success("Job updated!");
    } else {
      await addJob(form);
      toast.success("Job added!");
    }
    setForm({ title: "", company: "", location: "", description: "" });
    onSuccess();
  };

  return (
    <form onSubmit={handleSubmit} className="p-4 space-y-3 bg-white rounded-xl shadow-md">
      <input name="title" placeholder="Job Title" value={form.title} onChange={handleChange} className="w-full p-2 border rounded" />
      <input name="company" placeholder="Company" value={form.company} onChange={handleChange} className="w-full p-2 border rounded" />
      <input name="location" placeholder="Location" value={form.location} onChange={handleChange} className="w-full p-2 border rounded" />
      <textarea name="description" placeholder="Job Description" value={form.description} onChange={handleChange} className="w-full p-2 border rounded" />
      <button type="submit" className="w-full px-3 py-2 bg-blue-600 text-white rounded-lg">Save</button>
    </form>
  );
}
