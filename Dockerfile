# Ref: https://www.keycloak.org/server/containers
FROM quay.io/keycloak/keycloak:26.0.5 as builder

ENV KC_BOOTSTRAP_ADMIN_USERNAME=admin
ENV KC_BOOTSTRAP_ADMIN_PASSWORD=admin

# Add the provider JAR file to the providers directory
COPY --chown=keycloak:keycloak --chmod=644 target/keycloak-change-password-1.0.jar /opt/keycloak/providers/myprovider.jar

ENTRYPOINT ["/opt/keycloak/bin/kc.sh"]

# docker build . -t mykeycloak
# docker run --rm --name mykeycloak  -p 8080:8080 mykeycloak start-dev