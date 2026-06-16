import http from 'node:http';

const server = http.createServer();

server.on('request', (req, res) => {
    console.log('Request received.');

    req.socket.on('data', (data) => {
        console.log(data.toString());
    }).on('end', () => {
        console.log('Data stream ended.');
    });

    const route = req.url.split('/');

    if (route[1] === 'else') {
        res.end('Alternative response.');
    }
    res.end();
    server.close();
}).on('close', () => {
    console.log('Server disconnected.');
}).on('error', (err) => {
    console.error(err);
}).on('listening', () => {
    console.log('Server started and listening...');
}).listen(4200);
