# Example application for ELK stack with filebeat
## Prerequisites
To run this project, you must first install the following tools:
* Docker
* Kubernetes cluster
* Helm 3
* Nginx ingress (optional, if you don't want to use it, disable it in the kibana/values.yaml)

## Building the app
To build the java app, the only required step is to build its docker image.
```
docker build -t java-elk-test-app ./java-app/
```

## Setup the ELK stack with filebeat
To setup the stack, run following commands:
```
helm install filebeat filebeat/
helm install logstash logstash/
helm install elasticsearch elastic/
helm install kibana kibana/
```
Now, you should have filebeat DeamonSet created and filebeat should be running on all available worker nodes. You should see 3 instance of elasticsearch, one instance of logstash and one instance of kibana.
Kibana should be available at http://kibana-example.local/

## Deploy the test application
To deploy the test application, run the following command:
```
kubectl apply -f java-app/app-kube.yaml
```
Now you can port-forward to the service elk-java-test-app-service on port 18080 (`kubectl port-forward service/elk-java-test-app-service 18080`) and call endpoint `/test`. This endpoint will log a trace message using logback.
Then, on the discover page, you should be able to filter these logs by using following filters:

 ![Kibana filters](kibana-filter.PNG)