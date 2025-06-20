import React, {useState} from "react";
export default SearchWeather;
import axios from "axios";


function SearchWeather(){

    const [city, setCity]= useState("");
    const[weather,setWeather]=useState(null);

    const handleSearch = async()=>{

        try{
            const response = await axios.get(`http://localhost:8080/api/weather/${city}`)
            setWeather(response.data);
        }catch(error){
            console.log("Error fetching weather: ", error)
            setWeather(null)
        }
    };

    return (
        <div style={{ textAlign: "center", padding: "2rem"}}>
            <h2>Weather Search</h2>
            <input
            type="text"
            placeholder="Enter city"
            value={city}
            onChange={(e)=> setCity(e.target.value)}

            />
            <button onClick={handleSearch}>Search</button>

            {weather && (
                <div style={{ marginTop: "1rem"}}>
                    <h3>{weather.city}</h3>
                    <p>Condition: {weather.condition}</p>
                    <p>Temperature: {weather.temperature}°C</p>
                </div>
            )}

        </div>
    );


}