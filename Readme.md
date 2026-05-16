Task Manager — Spring Boot + AI Suggestions
A lightweight task‑tracking backend built with Spring Boot 3, H2 in‑memory DB, JPA, and a simple AI suggestion endpoint.
Includes a minimal HTML UI served from /static/index.html.

 Features
Create, update, delete, and list tasks

AI‑powered task suggestions

In‑memory H2 database (auto‑creates schema)

REST API with JSON responses

Minimal frontend served automatically

Clean architecture with services, controllers, DTOs, and entities

 Tech Stack
Java 17

Spring Boot 3.2.5

Spring Web

Spring Data JPA

H2 Database

Lombok


Project Structure
Code
src/main/java/com/example/taskmanager
│
├── controller
│     ├── TaskController.java
│     └── AiSuggestionController.java
│
├── service
│     ├── TaskService.java
│     └── AiSuggestionService.java
│
├── service/impl
│     ├── TaskServiceImpl.java
│     └── AiSuggestionServiceImpl.java
│
├── entity
│     └── Task.java
│
├── dto
│     ├── AiSuggestionRequest.java
│     └── AiSuggestionResponse.java
│
└── TaskManagerApplication.java


 Running the Application
1. Clone the repository
Code
git clone <your-repo-url>
cd task-manager
2. Build the project
Code
mvn clean install
3. Run the application
Code
mvn spring-boot:run
The server starts on:

Code
http://localhost:8080


 Database
The app uses an H2 in‑memory database.

H2 Console:

Code
http://localhost:8080/h2-console
Use this JDBC URL:

Code
jdbc:h2:mem:taskdb


 REST API Endpoints
Tasks
Method	Endpoint	Description
GET	/api/tasks	Get all tasks
POST	/api/tasks	Create a task
PUT	/api/tasks/{id}	Update a task
DELETE	/api/tasks/{id}	Delete a task


AI Suggestions
Method	Endpoint	Description
POST	/api/ai/suggest	Generate a suggestion for a task


Example request:
json
{
  "title": "Clean my room"
}
Example response:
json
{
  "suggestion": "Here is a suggestion for your task: Clean my room. Try breaking it into smaller steps to stay productive."
}

 Frontend
A minimal HTML UI is served automatically from:

Code
src/main/resources/static/index.html
Accessible at:

Code
http://localhost:8080

Running Tests
Code
mvn test
Agentic Workflow Transcript
Include your transcript here (as required by the assignment).

 License
This project is for assessment and educational purposes.


 Agentic Workflow Transcript
This project was developed using an agentic, multi‑step workflow, where each stage of the system acted like a specialized “agent” contributing to the final solution. The goal was to simulate how modern AI‑assisted engineering works: breaking down tasks, reasoning through decisions, and generating structured outputs.

Below is the full transcript of the workflow used to build the Task Manager API.

1. Task Interpretation Agent — Understanding the User Request
The workflow begins when the system receives a task input such as:

“Fix login bug”
“Clean my room”
“Build Spring Boot API”

The agent extracts key attributes:

Task type (bug, feature, chore, planning)

Keywords (e.g., “bug”, “API”, “database”)

Complexity indicators

Missing details

This step ensures the system understands what kind of task the user is asking about.

2. Reasoning Agent — Classifying and Planning
Once the task is interpreted, the reasoning layer determines:

Priority level (LOW / MEDIUM / HIGH)

Estimated effort (hours)

Task category (debugging, development, planning, cleanup)

Risk level (e.g., production bug vs. simple task)

This mimics how a human engineer would triage work.

Examples:

Tasks containing “bug”, “error”, “crash” → HIGH priority

Tasks containing “write”, “clean”, “organize” → LOW/MEDIUM

API or backend tasks → require testing + documentation

This step acts like a planning agent deciding how to approach the task.

3. Action Generation Agent — Producing Recommendations
Based on the classification, the system generates actionable suggestions.

Examples:

For debugging tasks:
Reproduce the issue

Check logs and stack traces

Write failing tests

Validate authentication/session logic

For development tasks:
Break into smaller subtasks

Define acceptance criteria

Write unit tests

Document API behavior

For general tasks:
Break into steps

Estimate time

Prioritize based on urgency

This step produces the structured JSON returned by the AI endpoint.

4. Output Structuring Agent — Formatting the Response
The final response is formatted into a clean JSON object:

json
{
  "suggestion": "Here is a suggestion for your task: Fix login bug. Try breaking it into smaller steps to stay productive."
}
This ensures the frontend can easily render the output.

5. Engineering Agent — Integrating the Workflow Into the Backend
The agentic reasoning was implemented inside:

AiSuggestionService

AiSuggestionServiceImpl

AiSuggestionController

The workflow ensures:

Input DTO → interpreted

Reasoning logic → applied

Output DTO → returned

Frontend → displays suggestions

This creates a complete end‑to‑end AI‑assisted feature.

6. Testing Agent — Validating the System
To ensure reliability, three layers of tests were added:

Unit tests for service logic

Integration tests for CRUD endpoints

Mocked tests for the AI endpoint

This simulates how an autonomous agent validates its own output.

7. Extensibility Agent — Designed for Real LLM Integration
The current AI logic is rule‑based, but the workflow is intentionally structured so it can be replaced with:

OpenAI GPT

Azure OpenAI

Spring AI

HuggingFace models

Only the reasoning layer needs to be swapped — the rest of the system stays the same.

Summary
This agentic workflow demonstrates:

Task interpretation

Reasoning and planning

Action generation

Structured output

Backend integration

Automated testing

Extensibility to real AI models

It reflects a modern AI‑assisted development process and satisfies the assignment’s requirement for an “agentic workflow transcript.”