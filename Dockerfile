FROM jenkins/jenkins:lts

# Set user root to allow us to install the rest of what's needed
USER root

# Install OpenJDK 11 (or the version you need) and other dependencies
RUN apt-get update && apt-get install -y \
    openjdk-11-jdk \
    wget \
    && rm -rf /var/lib/apt/lists/*

#==============================
# Google Chrome Stable - Latest
#==============================
RUN wget -q -O - https://dl-ssl.google.com/linux/linux_signing_key.pub \
        | apt-key add - \
  && echo "deb http://dl.google.com/linux/chrome/deb/ stable main" \
        > /etc/apt/sources.list.d/google.list \
  && apt-get update \
  && apt-get install -y google-chrome-stable \
  && apt-get -qyy autoremove \
  && rm -rf /var/lib/apt/lists/* \
  && apt-get clean \
  && echo google-chrome-stable --version

# Go back to non-sudo user
USER jenkins

