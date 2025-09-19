export default function JobCard({ job, onDelete, onEdit }) {
  return (
    <div className="p-4 bg-white shadow-md hover:shadow-lg transition rounded-2xl">
      <h2 className="text-xl font-bold">{job.title}</h2>
      <p className="text-gray-600">{job.company} • {job.location}</p>
      <p className="mt-2">{job.desc}</p>
      <div className="flex gap-3 mt-3">
        <button onClick={() => onEdit(job)} className="px-3 py-1 border rounded-lg">Edit</button>
        <button onClick={() => onDelete(job.id)} className="px-3 py-1 bg-red-500 text-white rounded-lg">Delete</button>
      </div>
    </div>
  );
}
