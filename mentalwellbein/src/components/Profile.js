import React, { useEffect, useState } from "react";
import "../styles/Profile.css";

function Profile() {
  const [userDetails, setUserDetails] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  const userId = 1; // Replace with dynamic user ID if needed

  useEffect(() => {
    const fetchProfile = async () => {
      try {
        // Fetch profile using dynamic user ID
        const response = await fetch(`http://localhost:8080/${userId}/profile`);
        if (!response.ok) {
          throw new Error("Failed to fetch profile details");
        }
        const data = await response.json();
        setUserDetails(data);
      } catch (err) {
        setError(err.message);
      } finally {
        setLoading(false);
      }
    };
    fetchProfile();
  }, [userId]); // Runs again if the userId changes

  if (loading) return <p>Loading...</p>;
  if (error) return <p>Error: {error}</p>;

  return (
    <div className="profile">
      <h2>Profile</h2>
      <ul>
        {Object.entries(userDetails).map(([key, value]) => (
          <li key={key}>
            <strong>{key.charAt(0).toUpperCase() + key.slice(1)}:</strong> {value}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default Profile;
