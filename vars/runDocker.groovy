//vars/runDocker.groovy
def call(String appName, String buildNumber, String hostPort = "5000") {
    sh """
    # Stop the old container if it exists
                docker stop ${APP_NAME}-main || true

                # Remove the old container if it exists
                docker rm ${APP_NAME}-main || true
        docker run -d \
        --name ${appName}-main-${buildNumber} \
        -p ${hostPort}:5000 \
        ${appName}:${buildNumber}
    """
}
