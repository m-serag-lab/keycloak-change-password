package com.seraglab;

import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;

import org.keycloak.authentication.RequiredActionContext;
import org.keycloak.authentication.requiredactions.UpdatePassword;
import org.keycloak.credential.CredentialInput;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.UserCredentialModel;
import org.keycloak.models.UserModel;
import org.keycloak.models.utils.FormMessage;

@Slf4j
public class CustomUpdatePassword extends UpdatePassword {

    public CustomUpdatePassword(KeycloakSession session) {
        super(session);
    }

    @Override
    public void processAction(RequiredActionContext context) {
        final UserModel user = context.getUser();
        final String oldPassword = context.getHttpRequest().getDecodedFormParameters().getFirst("password-old");
        final CredentialInput oldPasswordCredential = UserCredentialModel.password(oldPassword);

        if (user.credentialManager().isValid(oldPasswordCredential)) {
            super.processAction(context);
        } else {
            Response challenge = context.form().setAttribute("username",
                            context.getAuthenticationSession().getAuthenticatedUser().getUsername())
                    .addError(new FormMessage("password-old", "incorrectOldPassword"))
                    .createResponse(UserModel.RequiredAction.UPDATE_PASSWORD);
            context.challenge(challenge);
        }
    }
}
