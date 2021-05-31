### Prerequisites

To be able to run this application you must need to install Node.js 12.0.0 or
newer. Additionally, You must specify several enviroment variables to be able
to connect to firebase. (This credentials can be found in your firebase
project settings).

```
API_KEY=
TYPE=
PROJECT_ID=
PRIVATE_KEY_ID=
PRIVATE_KEY=
CLIENT_EMAIL=
CLIENT_ID=
AUTH_URI=
TOKEN_URI=
AUTH_PROVIDER_X509_CERT_URL=
CLIENT_X509_CERT_URL=
```


Secondly, you must create a client app in firebase to get an `API_KEY` to be
able to sign in with the rest API. Finally, you must allow signup with email and
password in the authentication tab on firebase.

### Development

If you want to contribute to this project you may want to use live preview
technology, you must use two different terminals to run the application the
first for express rest API and the second for the react frontend.

*Example of the rest API*

```bash
cd asesorex
npm install
npm run dev-start
```

*Example of react frontend*

```bash
cd asesorex
cd client
npm install
npm run start
```

### Production

To deploy this application in the Amazon Web Services, you need to deploy first the 
express server on the aws lambda service, to be able to do this, you need install 
the serverless package globally with the Node Nackage Manager

```bash
npm install -g serverless
```

The Serverless Framework build applications comprised of microservices that run in response 
to events, auto-scale for you, and only charge you when they run. This lowers the total cost 
of maintaining your apps, enabling you to build more logic, faster.

Once created, you must supply your amazon web services credentials to serverless to create the 
lambda project on your account through the terminal. This credentials can be found in your AWS
console or with the project admin.

```bash
serverless config credentials --provider aws --key <AWSAccessKeyId> --secret <AWSSecretKey>
```

Now you can deploy the express server with AWS lambda functions.
Note: The serverless configuration is already created in the project with serverless.yml 
file and the application will be deployed in brazil for better latency configuration


```bash
cd asesorex
serverless deploy
```

To deploy the frontend, you must have access to amplify console.

After this commands you should be able to access all the functionalities of
cargox from one single domain.