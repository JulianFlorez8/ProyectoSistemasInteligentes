import React from "react";
import styles from "./Grid.module.css";
import { useState } from "react";

function Grid(props) {
  const [matrix, setMatrix] = useState(
    Array(props.rows)
      .fill()
      .map(() => Array(props.columns).fill(0))
  );

  const [mouseDown, setMouseDown] = useState(false);

  const gridStyle = {
    display: "grid",
    gridTemplateRows: `repeat(${props.rows}, 1fr)`,
    gridTemplateColumns: `repeat(${props.columns}, 1fr)`,
  };

  const paint = (row, col, click) => {
    if (!mouseDown && !click) return;
    const newMatrix = [...matrix];
    newMatrix[row][col] = newMatrix[row][col] == 0 ? 1 : 0;
    setMatrix(newMatrix);
  };

  return (
    <div
      style={gridStyle}
      className={styles.grid}
      onMouseLeave={() => setMouseDown(false)}
    >
      {matrix.map((row, rowIndex) =>
        row.map((value, colIndex) => (
          <div
            className={value == 1 ? styles.wall : styles.square}
            key={`${rowIndex}-${colIndex}`}
            value={value}
            onMouseDown={() => setMouseDown(true)}
            onMouseUp={() => setMouseDown(false)}
            onClick={() => paint(rowIndex, colIndex, true)}
            onMouseEnter={() => paint(rowIndex, colIndex, false)}
          ></div>
        ))
      )}
    </div>
  );
}

export default Grid;
