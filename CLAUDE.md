## Project Overview

This is a Spring Boot project for a simple SNS (Social Networking Service) like Twitter.
It is a web application where users can post messages and see a timeline of posts.

## Java / Spring Boot

- When making changes to Spring Boot projects, always verify dependency names and versions against the project's existing BOM/parent POM before adding new dependencies. For Spring Boot 4.x, confirm package names have not changed from 3.x.
- After editing YAML files (application.yml, docker-compose.yml, etc.), always validate the YAML structure is intact by running a quick parse check or reviewing indentation. Never partially edit YAML blocks.

## Response Style

- When asked to explain code or changes, respond with inline text explanations in the conversation. Do NOT create separate markdown files or enter plan mode for explanations unless explicitly asked to write documentation.

## Testing & Verification

- Always run `./gradlew build` after making code changes to verify they compile successfully before reporting completion.
