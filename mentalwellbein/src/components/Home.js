import React, { useState, useEffect } from "react";
import '../styles/Home.css';
import image from './image.jpg'; // Import the image
import { useParams } from "react-router-dom";

/**
 * @function Home
 * @returns {JSX.Element}
 */
function Home() {
  const { userId } = useParams();
  const defaultUserId = userId || "1"; // Default to "1" if userId is not provided

  const [userData, setUserData] = useState(null); // State to store fetched user data

  useEffect(() => {
    // Fetch user data from backend (Spring Boot)
    fetch(`http://localhost:8080/${defaultUserId}`)
      .then(response => response.json())
      .then(data => setUserData(data)) // Set the fetched data into state
      .catch(error => console.error("Error fetching user data:", error));
  }, [defaultUserId]);

  // Show loading text if userData is not fetched yet
  if (!userData) {
    return <div>Loading...</div>;
  }

  return (
    <div className="home">
      <div className="img">
        <img src={image} alt="Mental Health" /> {/* Using imported image */}
      </div>
      <div className="di2">
        <h1>Welcome, {userData.name}!</h1> {/* Dynamically displaying user's name */}
        <p className="quote">{userData.quote || "Your mental health matters. Take care of yourself!"}</p>
      </div>
    </div>
  );
}

export default Home;
