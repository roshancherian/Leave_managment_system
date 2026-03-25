import { useEffect, useState } from "react";
import API from "../services/api";

function MyLeaves() {
    const [leaves, setLeaves] = useState([]);

    useEffect(() => {
        const fetchLeaves = async () => {
            const userId = localStorage.getItem("userId");

            const res = await API.get(`/leave/my?userId=${userId}`);
            setLeaves(res.data);
        };

        fetchLeaves();
    }, []);

    return (
        <div>
            <h2>My Leaves</h2>

            {leaves.map((leave) => (
                <div key={leave.id}>
                    <p>{leave.reason}</p>
                    <p>{leave.status}</p>
                </div>
            ))}
        </div>
    );
}

export default MyLeaves;