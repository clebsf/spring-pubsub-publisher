# Spring PubSub - GCP Pub/Sub Messaging Application

This Spring Boot application provides a simple API for publishing messages to Google Cloud Pub/Sub.

## Prerequisites

- JDK 21
- Maven 3.6+
- Google Cloud Platform account
- Google Cloud CLI (gcloud)

## Installing Google Cloud CLI (gcloud)

### macOS Installation

1. Download the Google Cloud CLI installer:

```bash
curl https://sdk.cloud.google.com | bash
```

2. Restart your terminal or run:

```bash
source ~/.zshrc
```

3. Initialize the gcloud CLI:

```bash
gcloud init
```

4. Follow the prompts to:
    - Log in with your Google account
    - Select your GCP project

### Setting Up Your GCP Project

1. List your GCP projects:

```bash
gcloud projects list
```

2. Set your default project:

```bash
gcloud config set project YOUR_PROJECT_ID
```

3. Enable the Pub/Sub API:

```bash
gcloud services enable pubsub.googleapis.com
```

4. Create a Pub/Sub topic:

```bash
gcloud pubsub topics create spring-pubsub
```

## Running the Application

1. Set the GCP project ID environment variable:

```bash
export GCP_PROJECT_ID=YOUR_PROJECT_ID
```

2. Build and run the application:

```bash
mvn spring-boot:run
```

## Using the API

The application exposes a REST endpoint to publish messages to GCP Pub/Sub:

### Publish a Message

```bash
curl -X POST http://localhost:8080/message/publish -H "Content-Type: text/plain" -d "Hello Pub/Sub!"
```

The message will be published to the "spring-pubsub" topic in your GCP project.

## Authentication

The application uses the GCP credentials from your gcloud CLI authentication. If running in a different environment, you may need to set up service account credentials:

```bash
gcloud auth application-default login
```

## Project Structure

- `MessageController`: REST controller for publishing messages
- `application.properties`: Configuration for GCP Pub/Sub integration

## Additional Resources

For more information on Google Cloud Pub/Sub with Spring, refer to the [Google Cloud Pub/Sub Sample](https://github.com/GoogleCloudPlatform/spring-cloud-gcp/tree/main/spring-cloud-gcp-samples/spring-cloud-gcp-pubsub-sample).