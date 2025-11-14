# Scientific Calculator with Full DevOps Pipeline (CS 816 Mini Project)

This project implements a command-line Scientific Calculator in Java and wraps the entire development lifecycle within a complete DevOps toolchain, demonstrating Continuous Integration (CI) and Continuous Deployment (CD).

The application provides a user menu for the following operations:
* Square root ($\sqrt{x}$)
* Factorial ($!x$)
* Natural Logarithm ($\ln(x)$)
* Power ($x^b$)

The project utilizes a toolchain including *GitHub* (SCM), *Maven/JUnit* (Build/Test), *Jenkins* (CI), *Docker* (Containerization), and *Ansible* (Deployment).

---

## Demonstration Workflow (Running the CI/CD Pipeline)

This workflow demonstrates the full Continuous Integration and Deployment process using three separate terminal sessions and IntelliJ.

### Prerequisites

1.  *Docker & Jenkins:* Must be running on your system.
2.  *Ngrok:* The client must be installed and authenticated.
3.  *Ansible:* Installed within a virtual environment (ansible_env).
4.  *GitHub Webhook:* The Payload URL must be updated in GitHub Settings to the current public URL provided by ngrok.

### Execution Steps

| Terminal | Step | Command / Action | Purpose |
| :---: | :--- | :--- | :--- |
| *Terminal 1* | *Start Ngrok Tunnel* | ngrok http 8080 | Creates a public, secure tunnel to the local Jenkins instance (port 8080), enabling the GitHub webhook trigger. *Note:* The dynamic URL must be copied and updated in GitHub. |
| *IntelliJ / Terminal* | *Trigger CI* | git push origin master | Pushing code to GitHub triggers the webhook via ngrok, which starts the full Jenkins pipeline (Build, Test, Containerize, Push to Docker Hub). |
| *Terminal 2* | *Activate Ansible* | source ansible_env/bin/activate | Activates the virtual environment containing the Ansible installation. |
| *Terminal 2* | *Deploy Application* | ansible-playbook -i inventory.ini ansible-playbook.yml -K | Executes the deployment playbook. It pulls the latest image from Docker Hub and starts the persistent application container. |
| *Terminal 3* | *Verify Deployment* | sudo docker ps | Checks if the container is successfully running in the background. |
| *Terminal 3* | *Access Application* | docker run -it --rm trupti1812/scientific-calculator:latest | Runs a temporary, interactive session of the calculator for testing and demonstration. |

---

For more information about the project's internal working, including tool configurations, justification for technical decisions, and full script details, please go through the project report.
