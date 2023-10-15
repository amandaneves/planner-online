const PROXY_CONFIG = [
  {
    context: ['/api'],
    // target: 'http://planner-spring.us-west-2.elasticbeanstalk.com/',
    target: 'http://localhost:8080/',
    secure: false,
    logLevel: 'debug',
  }
]

module.exports = PROXY_CONFIG;
