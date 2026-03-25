import Login from "./components/Login";
import Register from "./components/Register";
import ApplyLeave from "./components/ApplyLeave";
import MyLeaves from "./components/MyLeaves";

function App() {
    return (
        <div>
            <h1>Leave Management</h1>

            <Register />
            <Login />
            <ApplyLeave />
            <MyLeaves />
        </div>
    );
}

export default App;