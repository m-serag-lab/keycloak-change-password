# Keycloak Change Password

## Output

- Use [this link](http://localhost:8080/realms/master/protocol/openid-connect/auth?kc_action=UPDATE_PASSWORD&client_id=security-admin-console&redirect_uri=http%3A%2F%2Flocalhost%3A8080%2Fadmin%2Fmaster%2Fconsole%2F%23%2Fmaster%2Fclients&state=676c0ba0-2d81-4c31-ab57-f9cd477683cf&response_mode=query&response_type=code&scope=openid&nonce=403c68db-116c-4617-811b-a40af4f2320c&code_challenge=ej2NB5B6TGV-zOlN6Caix_wzohMF3v5OXfiBwiFS9-I&code_challenge_method=S256) to open change password page

![](https://github.com/m-serag-lab/keycloak-change-password/blob/main/result.gif)

## Prerequisite
- Java 17
- docker

## Run

- `./mvnw clean install`
- `docker build . -t mykeycloak`
- `docker run --rm --name mykeycloak  -p 8080:8080 mykeycloak start-dev`

## Resources
- https://github.com/keycloak/keycloak/issues/12943
- https://www.keycloak.org/server/containers
- https://www.keycloak.org/docs/latest/server_development/
