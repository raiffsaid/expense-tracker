import styled from "styled-components";

export const Container = styled.div`
  flex: 1 1 0px;

  @media (max-width: 768px) {
    margin: 0 1rem;
  }
`;

export const Title = styled.div`
  text-align: center;
  font-weight: bold;
  color: #888;
  margin-bottom: 5px;
`;

export const Info = styled.div<{ color?: string }>`
  text-align: center;
  font-weight: bold;
  color: ${props => props.color ?? '#000'};

  @media (max-width: 768px) {
    margin: 0 1rem;
    white-space: nowrap;
  }
`;