import { useState } from "react";
import reactLogo from "./assets/react.svg";
import "./App.css";
import Grid from "./components/Grid/Grid.jsx";

function App() {
  const [count, setCount] = useState(0);

  return (
    <div className="App">
      <Grid rows={20} columns={20}></Grid>
      <div className="card">
        <button onClick={() => setCount((count) => count + 1)}>
          count is {count}
        </button>
      </div>
    </div>
  );
}

export default App;
