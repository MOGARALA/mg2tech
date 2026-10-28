# MG2 Technologies Java Application

Starter project: Java 21, Spring Boot, Maven, Docker and Kubernetes/AKS.

## APIs
- `GET /api/v1/home` — company details and services
- `GET /api/v1/courses` — sample training course catalog
- `GET /api/v1/health` — simple application health
- `GET /actuator/health` — Spring Boot Actuator health

## Run locally
Requirements: JDK 21 and Maven 3.9+.
```bash
mvn clean verify
mvn spring-boot:run
```
Open `http://localhost:8080/api/v1/home`.

## Docker
```bash
docker build -t mg2-technologies:1.0.0 .
docker run --rm -p 8080:8080 mg2-technologies:1.0.0
```

## Kubernetes / AKS
1. Push the image to Azure Container Registry (ACR).
2. Replace `YOUR_ACR.azurecr.io` in `k8s/deployment.yaml` with your registry.
3. Ensure AKS can pull the image, and configure the correct ingress controller and TLS secret.
4. Apply manifests:
```bash
kubectl apply -f k8s/namespace.yaml
kubectl apply -f k8s/configmap.yaml
kubectl apply -f k8s/deployment.yaml
kubectl apply -f k8s/service.yaml
kubectl apply -f k8s/ingress.yaml
kubectl -n mg2 rollout status deployment/mg2-api
kubectl -n mg2 get pods,svc,ingress
```

The Ingress example is for NGINX Ingress Controller. If your AKS uses Azure Application Gateway Ingress Controller (AGIC), adapt the class, annotations, TLS and routing accordingly.

## Production considerations
- Use immutable image tags or image digests, not `latest`.
- Configure HTTPS, WAF, network restrictions and least-privilege RBAC.
- Use managed identity/workload identity for Azure access.
- Store credentials in Azure Key Vault; never commit secrets.
- Add a database and migrations before persisting student registrations.
- Add HPA, PodDisruptionBudget, monitoring, backups and gated CI/CD.
- Pin GitHub Actions to reviewed commit SHAs for hardened supply-chain security.

This is a starter application, not a complete public-facing website or fully hardened production deployment.

## Docker Build 
- docker build -t mg2-frontend:1.0.0 .
- sudo ss -lntp | grep ':80 '
- docker ps
- docker run -d --name mg2-frontend --restart unless-stopped -p 80:80 mg2-frontend:1.0.0
- curl -I http://localhost/
