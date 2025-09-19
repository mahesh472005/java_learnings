export default function Navbar() {
  return (
    <nav className="bg-blue-600 text-white p-4 shadow-md">
      <div className="container mx-auto flex justify-between items-center">
        <h1 className="text-xl font-bold">Job Portal</h1>
        <ul className="flex gap-6">
          <li><a href="/" className="hover:underline">Jobs</a></li>
          <li><a href="/" className="hover:underline">Add Job</a></li>
        </ul>
      </div>
    </nav>
  );
}
