import { createGlobalStyle } from 'styled-components';
 
const GlobalStyle = createGlobalStyle`
  * {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
  }

  :focus {
    outline: transparent;
  }

  @media (max-width: 768px) {
    html {
      font-size: 87.5%;
    }
  }
`;
 
export default GlobalStyle;