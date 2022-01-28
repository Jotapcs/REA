const proxy = [
    {
      context: '/BackEndRea_war/webapi',
      target: 'http://localhost:8080',
      pathRewrite: {'/BackEndRea_war/webapi' : ''}
    }
];

module.exports = proxy;

