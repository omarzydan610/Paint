import React, { useState } from "react";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import {
  faCaretUp,
  faCaretDown,
  faEraser,
  faRotateLeft,
  faRotateRight,
  faDownload,
  faUpload,
  faPaintBrush,
  faRulerHorizontal,
  faSquare,
  faCircle,
  faCaretDown as faDropdown,
} from "@fortawesome/free-solid-svg-icons";
import EllipseIcon from "./icons/ellipse.jsx";
import TriangleIcon from "./icons/triangle.jsx";
import RectangleIcon from "./icons/rectangle.jsx";
import ToolbarButton from "./ToolbarButton";
import "../../styles/Toolbar.css";

const Toolbar = ({
  selectedTool,
  setSelectedTool,
  fillColor,
  setFillColor,
  strokeColor,
  setStrokeColor,
  lineWidth,
  setLineWidth,
}) => {
  const [isDropdownOpen, setIsDropdownOpen] = useState(false);
  const [isLineWidthDropdownOpen, setIsLineWidthDropdownOpen] = useState(false);
  const [isToolbarHidden, setIsToolbarHidden] = useState(false);

  const tools = [
    { id: "freehand", icon: faPaintBrush, label: "Freehand" },
    { id: "line", icon: faRulerHorizontal, label: "Line" },
    { id: "square", icon: faSquare, label: "Square" },
    { id: "circle", icon: faCircle, label: "Circle" },
    { id: "rectangle", icon: RectangleIcon, label: "Rectangle" },
    { id: "triangle", icon: TriangleIcon, label: "Triangle" },
    { id: "ellipse", icon: EllipseIcon, label: "Ellipse" },
  ];

  const renderIcon = (tool) => {
    if (tool.icon instanceof Function) {
      const IconComponent = tool.icon;
      return <IconComponent />;
    }
    return <FontAwesomeIcon icon={tool.icon} />;
  };

  const getSelectedToolIcon = () => {
    const tool = tools.find((t) => t.id === selectedTool);
    if (!tool) return <FontAwesomeIcon icon={faPaintBrush} />;
    return renderIcon(tool);
  };

  const handleLineWidthSelection = (width) => {
    setLineWidth(width);
    setIsLineWidthDropdownOpen(false);
  };

  return (
    <div className={`toolbar-container ${isToolbarHidden ? "hidden" : ""}`}>
      <div className="toolbar">
        {/* Tool Selection Dropdown */}
        <div
          className="toolbar-dropdown-container"
          onClick={() => setIsDropdownOpen(!isDropdownOpen)}
        >
          <div className="toolbar-dropdown-selected">{getSelectedToolIcon()}</div>
          <FontAwesomeIcon
            icon={faDropdown}
            className="toolbar-dropdown-toggle"
          />
          {isDropdownOpen && (
            <ul className="toolbar-dropdown-list">
              {tools.map((tool) => (
                <li
                  key={tool.id}
                  className="toolbar-dropdown-item"
                  onClick={() => {
                    setSelectedTool(tool.id);
                    setIsDropdownOpen(false);
                  }}
                >
                  {renderIcon(tool)}
                  <span>{tool.label}</span>
                </li>
              ))}
            </ul>
          )}
        </div>

        {/* Line Width Dropdown */}
        <div
          className="toolbar-dropdown-container"
          onClick={() => setIsLineWidthDropdownOpen(!isLineWidthDropdownOpen)}
        >
          <div className="toolbar-dropdown-selected">
            <span
              style={{ fontSize: lineWidth + 7, display: "flex" }}
            >
              <FontAwesomeIcon icon={faCircle} />
            </span>
          </div>
          <FontAwesomeIcon
            icon={faCaretDown}
            className="toolbar-dropdown-toggle"
          />
          {isLineWidthDropdownOpen && (
            <ul className="toolbar-dropdown-list">
              {[1, 3, 5, 7, 9].map((width) => (
                <li
                  key={width}
                  className="toolbar-dropdown-item"
                  onClick={() => handleLineWidthSelection(width)}
                  style={{
                    fontSize: width + 7,
                    justifyContent: "center",
                  }}
                >
                  <FontAwesomeIcon icon={faCircle} />
                </li>
              ))}
            </ul>
          )}
        </div>

        {/* Buttons */}
        <ToolbarButton
          icon={<FontAwesomeIcon icon={faEraser} />}
          onClick={() => console.log("Eraser clicked")}
          title="Eraser"
          label="Eraser"
        />
        <input
          type="color"
          className="toolbar-color-input"
          value={fillColor}
          onChange={(e) => setFillColor(e.target.value)}
          title="Fill Color"
        />
        <input
          type="color"
          className="toolbar-color-input"
          value={strokeColor}
          onChange={(e) => setStrokeColor(e.target.value)}
          title="Stroke Color"
        />
        <ToolbarButton
          icon={<FontAwesomeIcon icon={faRotateLeft} />}
          onClick={() => console.log("Undo action")}
          title="Undo"
          label="Undo"
        />
        <ToolbarButton
          icon={<FontAwesomeIcon icon={faRotateRight} />}
          onClick={() => console.log("Redo action")}
          title="Redo"
          label="Redo"
        />
        <ToolbarButton
          icon={<FontAwesomeIcon icon={faDownload} />}
          onClick={() => console.log("Save action")}
          title="Save"
          label="Save"
        />
        <ToolbarButton
          icon={<FontAwesomeIcon icon={faUpload} />}
          onClick={() => console.log("Load action")}
          title="Load"
          label="Load"
        />
      </div>

      {/* Hide/Show Button */}
      <button
        className="toolbar-toggle"
        onClick={() => setIsToolbarHidden(!isToolbarHidden)}
      >
        <FontAwesomeIcon icon={isToolbarHidden ? faCaretDown : faCaretUp} />
      </button>
    </div>
  );
};

export default Toolbar;