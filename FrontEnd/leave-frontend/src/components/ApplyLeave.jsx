import { useState } from "react";
import API from "../services/api";

function ApplyLeave() {
    const [reason, setReason] = useState("");
    const [startDate, setStartDate] = useState("");
    const [endDate, setEndDate] = useState("");

    const applyLeave = async () => {
        const userId = localStorage.getItem("userId");

        try {
            await API.post(`/leave/apply?userId=${userId}`, {
                reason,
                startDate,
                endDate,
            });

            alert("Leave Applied");
        } catch (err) {
            alert("Error applying leave");
        }
    };

    return (
        <div>
            <h2>Apply Leave</h2>

            <input placeholder="Reason" onChange={(e) => setReason(e.target.value)} />
            <input type="date" onChange={(e) => setStartDate(e.target.value)} />
            <input type="date" onChange={(e) => setEndDate(e.target.value)} />

            <button onClick={applyLeave}>Apply</button>
        </div>
    );
}

export default ApplyLeave;